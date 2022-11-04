let body = $("body");
let g_page = "home";
let currentPage = 0;

$(document).ready(function () {
    buildPage("home");
});

function navigationListener(page) {
    g_page = page;
    getData(page).done(function (result) {
        buildPage(page, result);
    });
}

function buildPage(page, data) {
    let errMSG = $("#error");
    let sucMSG = $("#success");
    body.empty();
    body.append(errMSG);
    body.append(sucMSG);

    buildHeader();
    if (page === "home") {
        buildHome();
    }

    if (page !== "home" && data != null) {
        let container = $("<section class='t-up container d-flex justify-content-between'></section>")
        let heading = $("<h3 style='text-transform: uppercase;'></h3>").text(g_page)
        let createButton = $("<button class='btn btn-primary'>Create</button>")
        createButton.click(function (){
            getData(g_page + "/getPrototype").done(function (result) {
                getModal('create', result);
            });
        });

        container.append(heading);
        container.append(createButton);
        body.append(container);

        container = $("<section class='search-container d-flex container justify-content-between'></section>");

        let inpGroup = $("<div class='input-group'></div>")
        let search = $("<input type='search' id='search' placeholder='Search..' class='form-control' />");
        let button = $("<button class='btn btn-primary' type='button'>Search</button>");

        button.click(function () {
            let value = $("#search").val();
            page = insertParam(g_page + "/search", "searchValue", value);
            getData(page).done(function (result) {
                buildPage(page, result);
            });
        });

        inpGroup.append(search);
        inpGroup.append(button);
        container.append(inpGroup);
        body.append(container);

        buildTable(page, data);

        container = $("<section class='d-flex container justify-content-center'></section>");
        let pagination = $("<ul class='pagination'></ul>");
        let prev = $("<li class='page-item'><a class='page-link'>Previous</a></li>")
        let next = $("<li class='page-item'><a class='page-link'>Next</a></li>");

        prev.click(function () {
            currentPage--;
            getData(insertParam(page, "page", currentPage)).done(function (result) {
                buildPage(page, result);
            });
        });

        next.click(function () {
            currentPage++;
            getData(insertParam(page, "page", currentPage)).done(function (result) {
                buildPage(page, result);
            });
        });

        for (let i = 0; i < data.totalPages; i++) {
            let pageLink = $("<li class='page-item page-link'></li>").text(i + 1);

            if (i === currentPage) {
                pageLink = $("<li class='page-item active page-link'></li>").text(i + 1);
            }

            pageLink.click(function () {
                currentPage = i;
                getData(insertParam(page, "page", currentPage)).done(function (result) {
                    buildPage(page, result);
                });
            });

            pagination.append(pageLink);
        }

        if (currentPage !== 0) {
            pagination.prepend(prev);
        }

        if (currentPage !== data.totalPages - 1) {
            pagination.append(next);
        }

        container.append(pagination);
        body.append(container);
    }
    buildFooter();
}

function buildHeader() {

}

function buildFooter() {

}

function buildHome() {
    body.append("<section class='container table-links'></section>")

    let container = $(".table-links");
    container.append("<h4>Tables</h4>")

    container.append("<a class='link-info' onclick='navigationListener(\"subscribers\")'>Subscribers</a>")
    container.append("<a class='link-info' onclick='navigationListener(\"operators\")'>Mobile Operators</a>")
    container.append("<a class='link-info' onclick='navigationListener(\"requests\")'>Requests</a>")
    container.append("<a class='link-info' onclick='navigationListener(\"specialServices\")'>Special Services</a>")
    container.append("<a class='link-info' onclick='navigationListener(\"workingSchedules\")'>Working-Schedules</a>")
}

function getData(page) {
    return $.ajax({
        type: 'GET',
        url: '/api/' + page
    })
}

function del(page) {
    $.ajax({
        type: 'DELETE',
        url: '/api/' + page,
        success: (function () {
            navigationListener(g_page);
            insertSuccessMessage("success", "Entity Deleted");
        }),
        error: (function() {
            insertErrorMessage("error", "Could Not delete Entity")
        })
    })
}

function buildTable(page, data) {
    let section = $("<section class='container table-data'></section>")
    let table = $("<table class='table table-hover'></table>");
    let thead = $("<thead class='table-dark'></thead>");
    let thead_tr = $("<tr></tr>");

    let obj = data.content[0];
    for (let prop in obj) {
        if (Object.prototype.hasOwnProperty.call(obj, prop)) {
            let th = $("<th scope='col'></ths>").text(prop);
            $(th).click(function () {
                if (page.includes("d_")) {
                    prop = "a_" + prop;
                } else {
                    prop = "d_" + prop;
                }

                page = insertParam(page, "sortBy", prop);
                getData(page).done(function (result) {
                    currentPage = 0;
                    buildPage(page, result);
                });
            });
            thead_tr.append(th);
        }
    }

    let view_col = $("<th scope='col'></ths>").text("");
    let edit_col = $("<th scope='col'></ths>").text("");
    let del_col = $("<th scope='col'></ths>").text("");
    thead_tr.append(view_col);
    thead_tr.append(edit_col);
    thead_tr.append(del_col);

    thead.append(thead_tr);

    let tbody = $("<tbody></tbody>")
    for (let i = 0; i < data.content.length; i++) {
        let obj = data.content[i];

        let tbody_tr = $("<tr></tr>")
        for (let prop in obj) {
            if (Object.prototype.hasOwnProperty.call(obj, prop)) {
                let th = $("<th></th>").text(obj[prop]);

                if (typeof obj[prop] === 'object' && obj[prop] != null) {
                    th = $("<th><button class='btn btn-outline-info'>Info</button></th>");
                    th.click(function () {
                        getData( prop + "s/" + obj[prop].id).done(function (result) {
                            getModal("view", result);
                        });
                    });
                }

                tbody_tr.append(th);
            }
        }

        let view_btn = $("<th><button type='button' class='btn btn-outline-info'>View</button></th>")
        let edit_btn = $("<th><button type='button' class='btn btn-outline-warning'>Edit</button></th>")
        let del_btn = $("<th><button type='button' class='btn btn-outline-danger'>Delete</button></th>")

        $(view_btn).click(function () {
            getData(g_page + "/" + obj.id).done(function (result) {
                getModal("view", result);
            });
        })

        $(edit_btn).click(function () {
            getData(g_page + "/" + obj.id).done(function (result) {
                getModal("edit", result);
            });
        })

        $(del_btn).click(function () {
            del(g_page + "/delete/" + obj.id);
        })

        tbody_tr.append(view_btn);
        tbody_tr.append(edit_btn);
        tbody_tr.append(del_btn);

        tbody.append(tbody_tr);
    }

    table.append(thead);
    table.append(tbody);
    section.append(table);
    body.append(section);
}

function getModal(type, data) {
    let modal = $("<div class='modal fade' id='modal' tabindex='-1' aria-labelledby='modalLabel'></div>")
    let modalDialog = $("<div class='modal-dialog' role='document'></div>")
    let modalContent = $("<div class='modal-content'></div>")

    let modalHeader = $("<div class='modal-header'></div>")
    let modalTitle = $("<h1 class='modal-title fs-5' id='modalLabel'></h1>").text(type);
    let closeBtn = $("<button type='button' class='btn-close' data-bs-dismiss='modal' aria-label='Close'></button>")
    modalHeader.append(modalTitle);
    modalHeader.append(closeBtn);

    let modalBody = $("<div class='modal-body'></div>")

    for (let prop in data) {
        if (Object.prototype.hasOwnProperty.call(data, prop)) {
            let formGroup = $('<div class="form-group"></div>')
            let label = $('<label></label>').text(prop);
            let input = $('<input>')

            if (typeof data[prop] === typeof 1) {
                input.attr("type", "number");
            } else if (prop.toLowerCase().includes("email")) {
                input.attr("type", "email");
            } else if (prop.toLowerCase().includes("time")) {
                input.attr("type", "time");
            } else if (typeof data[prop] === 'object' && data[prop] !== null) {
                input = $('<select class="form-select"></select>');
                let option = $('<option disabled>--SELECT--</option>');
                if (type === 'create') {
                    option.attr('selected', true);
                }
                input.append(option);

                getData( prop + "s/").done(function (result) {
                    for (let i = 0; i < result.content.length; i++) {
                        option = $('<option></option>').text(result.content[i].id + " - " + result.content[i].name);

                        if (result.content[i].id === data[prop].id) {
                            option.attr("selected", true);
                        }

                        option.attr("value", result.content[i].id);

                        input.append(option);
                    }
                });
            } else if (prop.toLowerCase().includes('day')) {
                input = $('<select class="form-select"></select>');
                let option = $('<option disabled>--SELECT--</option>');
                if (type === 'create') {
                    option.attr('selected', true);
                }
                input.append(option);

                option = $('<option value="0">Monday</option>');
                input.append(option);
                option = $('<option value="1">Tuesday</option>');
                input.append(option);
                option = $('<option value="2">Wednesday</option>');
                input.append(option);
                option = $('<option value="3">Thursday</option>');
                input.append(option);
                option = $('<option value="4">Friday</option>');
                input.append(option);
                option = $('<option value="5">Saturday</option>');
                input.append(option);
                option = $('<option value="6">Sunday</option>');
                input.append(option);
            } else {
                input.attr("type", "text");
            }

            label.attr("for", prop);

            input.attr("class", "form-control");
            input.attr("id", prop);

            if (type !== 'create') {
                input.attr("value", data[prop]);
            }

            input.attr("name", prop);

            formGroup.append(label);
            formGroup.append(input);
            modalBody.append(formGroup);
        }
    }

    let modalFooter = $("<div class='modal-footer'></div>")
    let closeButton = $("<button type='button' class='btn btn-secondary' data-bs-dismiss='modal'>Close</button>")
    modalFooter.append(closeButton);
    if (type === "edit" || type === "create") {
        let saveButton = $("<button type='button' class='btn btn-primary'>Save</button>")
        saveButton.click(async function () {
            let entity = {};

            for (let prop in data) {
                if (Object.prototype.hasOwnProperty.call(data, prop)) {
                    if (typeof data[prop] === 'object') {
                        await getData(prop + 's/' + $('#' + prop).find(":selected").val()).done(function (result) {
                            entity[prop] = result;
                        });
                        continue;
                    }
                    entity[prop] = $("#" + prop).val();
                }
            }

            save(g_page, entity);
        })
        modalFooter.append(saveButton);
    }

    modalContent.append(modalHeader);
    modalContent.append(modalBody);
    modalContent.append(modalFooter);

    modalDialog.append(modalContent);
    modal.append(modalDialog);

    body.append(modal);

    new bootstrap.Modal('#modal').show();

    $('.modal').on('hidden.bs.modal', function () {
        $(this).remove();
    });

    if (type === "view") {
        $("input").prop( "disabled", true );
        $("select").prop("disabled", true);
    }

    $('#id').attr("disabled", true);
}

function save(page, entity) {
    console.log(JSON.stringify(entity));

    $.ajax({
        type: 'POST',
        url: "/api/" + page + "/save",
        data: JSON.stringify(entity),
        contentType: 'application/json',
        success: (function () {
            insertSuccessMessage("success", "Entity Saved");
            navigationListener(g_page);
        }),
        error: (function () {
            insertErrorMessage("error", 'Could Not Save Entity');
        })
    })
}

function insertParam(page, param, value) {
    let regex = new RegExp(param + "=.*?(?=&)");
    let s = param + "=" + value;

    if (!page.includes('?')) {
        page = page + "?" + s + "&";
    } else if (page.includes(param)) {
        page = page.replace(regex, s + "&");
    } else {
        page = page + s + "&";
    }

    console.log( page);
    return page;
}

function insertSuccessMessage(id, text) {
    let element = document.getElementById(id);
    if (element == null) {
        insertMessage(id, text, 'alert-success');
    } else {
        element.parentElement.removeChild(element);
        insertMessage(id, text, 'alert-success');
    }
}

function insertErrorMessage(id, text) {
    let element = document.getElementById(id);

    if (element == null) {
        insertMessage(id, text, 'alert-danger');
    } else {
        element.parentElement.removeChild(element);
        insertMessage(id, text, 'alert-danger');
    }
}

function insertMessage(id, text, type) {
    let insertion = document.createElement('div');
    insertion.innerText = text;
    insertion.setAttribute('id', id);
    insertion.setAttribute('class', 'alert ' + type + ' alert-dismissible fade show');
    insertion.setAttribute('role', 'alert');
    insertion.style.marginTop='5px';
    insertion.style.textTransform='capitalize';

    insertion.classList.add('fixed-bottom');
    insertion.style.width='200px';
    insertion.style.marginLeft = '10px';

    let closeBtn = document.createElement('button');
    closeBtn.setAttribute('type', 'button');
    closeBtn.setAttribute('class', 'btn-close');
    closeBtn.setAttribute('data-bs-dismiss', 'alert');
    closeBtn.setAttribute('aria-label', 'Close');

    insertion.appendChild(closeBtn);
    body.append(insertion);
}