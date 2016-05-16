function eventListen(type, event, cbFn) {
	var elements = document.getElementsByTagName(type);
	for (var i = 0; i < elements.length; i++) {
		elements[i].addEventListener(event, cbFn, false);
	}
}

function registerTag(type, snippet) {
	eventListen(type, "click", snippet);
}