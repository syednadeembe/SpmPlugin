var projectDescriptionElement;
var showMoreElement;

$(function() {
    projectDescriptionElement = $('#project-description');
    showMoreElement = $('.show-more');

    projectDescriptionElement.hide();
})

function toggleHeader() {
    projectDescriptionElement.stop().toggle('fast');
    if(showMoreElement.text() === 'show more ...') {
        showMoreElement.text('show less ...');
    } else {
        showMoreElement.text('show more ...');
    }
}

function setDescription(content) {
    projectDescriptionElement.html(htmlDecode(content));
}

function setOverview() {
    var targetIuPage = "" + window.location.search;
    if (targetIuPage == "" || targetIuPage == "undefined") {
        return;
    }

    // Remove the leading '?'
    targetIuPage = targetIuPage.substring(1);
    
    document.getElementById('iuOverview').src = targetIuPage;
} 

function htmlDecode(input) {
    var e = document.createElement('div');
    e.innerHTML = input;
    return e.childNodes.length === 0 ? "" : e.childNodes[0].nodeValue;
}
