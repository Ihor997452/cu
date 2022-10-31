let body = $("body");
let g_page = "home";
let g_sortBy = "a_";

$(document).ready(function () {
    buildPage("home");
});

function navigationListener(page) {
    g_page = page;
    getData(page);
}

function buildPage(page, data) {
    body.empty();

    buildHeader();
    if (page === "home") {
        buildHome();
    }

    if (page !== "home" && data != null) {
        buildTable(page, data);
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
    container.append("<a class='link-info' onclick='navigationListener(\"mobile-operators\")'>Mobile Operators</a>")
    container.append("<a class='link-info' onclick='navigationListener(\"requests\")'>Requests</a>")
    container.append("<a class='link-info' onclick='navigationListener(\"special-services\")'>Special Services</a>")
    container.append("<a class='link-info' onclick='navigationListener(\"working-schedules\")'>Working-Schedules</a>")
}

function getData(page, isModal, modalType) {
    $.ajax({
        type: 'GET',
        url: '/api/' + page,
        success: (function (response) {
            if (isModal) {
                getModal(modalType, response);
            } else {
                buildPage(page, response);
            }
        })
    })
}

function del(page) {
    $.ajax({
        type: 'DELETE',
        url: '/api/' + page
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

                getData(insertParam(page, "sortBy", prop));
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
                tbody_tr.append(th);
            }
        }

        let view_btn = $("<th><button type='button' class='btn btn-outline-info'>View</button></th>")
        let edit_btn = $("<th><button type='button' class='btn btn-outline-warning'>Edit</button></th>")
        let del_btn = $("<th><button type='button' class='btn btn-outline-danger'>Delete</button></th>")

        $(view_btn).click(function () {
            getData(g_page + "/" + obj.id, true, "view");
        })

        $(edit_btn).click(function () {
            getData(g_page + "/" + obj.id, true, "edit");
        })

        $(del_btn).click(function () {
            del(page + "/" + obj.id);
            console.log(obj.id);
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
    console.log(data);

    if (type === "view") {
        $("input").prop( "disabled", true );
    }
}

function insertParam(page, param, value) {
    let regex = new RegExp(param + "=.*?(?=&)");
    let s = param + "=" + value;

    if (!page.includes('?')) {
        return page + "?" + s + "&";
    }

    if (page.includes(param)) {
        return page.replace(regex, s + "&");
    }

    return page + s + "&";
}