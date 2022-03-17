var submitBttn = document.getElementById('submitButton')
var messageToBePosted = document.getElementById('messageCreation')
var userId = user.userId;
var channelId = window.location.href.substring(window.location.href.lastIndexOf('/') + 1, queryString.length)
var userName = user.userName
console.log(userName)
console.log(channelId)

messageToBePosted.addEventListener('keypress', function(event) {
	if (event.keycode === 13) {
		console.log('posting message')
		let message = {
			senderName: userName,
			messageContent: messageToBePosted.value,
			channelId: channelId,
			userId: userId
		}
		messageToBePosted.value = ''
		console.log('posting message')
		fetch("/channel/${channelId}/createMessage", {
			method: "POST",
			headers: {
				"Content-Type": "application/json"
			},
			body: JSON.stringify(message)
		})
			.then((message) => { getMessages() })
	}
})

setInterval(getMessages, 500)

function getMessages() {
	fetch('/channel/${channelId}/getMessages', {
		method: "POST",
		header: {
			"Content-Type": "application/json"
		}
	})
		.then((response) => response.json())
		.then(function (messages) {
			addMessages(messages)
		});
}


function addMessages(messages) {
	var messageCenter = document.getElementById("messageCenter")
	messageCenter.innerHTML = ''
	for (var i = 0; i < messages.length; i++) {
		var div = document.createElement('div')
		div.innerHTML = messages[i].messageSender + ":" + messages[i].messageText;
		messageCenter.appendChild(div);
	}
}
