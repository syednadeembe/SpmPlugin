var cursorX;
var cursorY;
var tooltip;

$(function() {
    tooltip = document.getElementById('tooltip');
    document.onmousemove = function(e) {
        cursorX = e.pageX;
        cursorY = e.pageY;
        tooltip.style.top = cursorY - (tooltip.clientHeight / 3) + 'px';
        tooltip.style.left = (cursorX + 20) + 'px';
    }
})

function showTooltip(html) {
    tooltip.innerHTML = htmlDecode(html);
    tooltip.style.opacity = 0;
    tooltip.style.display = 'initial';
    if(parseInt(tooltip.scrollHeight) > parseInt(window.innerHeight)) {
        tooltip.innerHTML = '<p>You may not see the full content, please click for more information.</p>';
    }
    tooltip.style.opacity = 1;
}

function hideTooltip() {
    tooltip.style.display = 'none';
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
var cursorX;
var cursorY;
var tooltip;

$(function() {
    tooltip = document.getElementById('tooltip');
    document.onmousemove = function(e) {
        cursorX = e.pageX;
        cursorY = e.pageY;
        tooltip.style.top = cursorY - (tooltip.clientHeight / 3) + 'px';
        tooltip.style.left = (cursorX + 20) + 'px';
    }
})

function showTooltip(html) {
    tooltip.innerHTML = htmlDecode(html);
    tooltip.style.opacity = 0;
    tooltip.style.display = 'initial';
    if(parseInt(tooltip.scrollHeight) > parseInt(window.innerHeight)) {
        tooltip.innerHTML = '<p>You may not see the full content, please click for more information.</p>';
    }
    tooltip.style.opacity = 1;
}

function hideTooltip() {
    tooltip.style.display = 'none';
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
