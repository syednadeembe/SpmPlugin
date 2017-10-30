var infoBox;
var infoBoxContent;

$(function() {
    infoBox = document.getElementById('info-box');
    infoBoxContent = document.getElementById('info-box-content');

    infoBox.addEventListener('click', hideInfoBox);
    infoBoxContent.addEventListener('click', function(e) {
        e.stopPropagation();
    });
})

function actionInfoBox(html) {
    if(infoBox.style.display === 'initial') {
        hideInfoBox();
    } else {
        showInfoBox(html);
    }
}

function showInfoBox(html) {
    infoBoxContent.innerHTML = htmlDecode(html);
    $('#info-box').fadeIn();
}

function hideInfoBox() {
    $('#info-box').fadeOut();
}

/*
 * After creation of DOM element and insertion of html value, the value
 * will be converted to valid HTML tags.
 */
function htmlDecode(input) {
    var e = document.createElement('div');
    e.innerHTML = input;
    return e.childNodes.length === 0 ? "" : e.childNodes[0].nodeValue;
}