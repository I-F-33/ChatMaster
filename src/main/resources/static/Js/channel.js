var submitBttn = document.getElementById('submitButton')
var messageToBePosted = document.getElementById('messageCreation')
var userId = user.userId;
var channelId = window.location.href.substring(window.location.href.lastIndexOf('/') + 1, queryString.length)
var userName = user.userName
console.log(channelId)

messageToBePosted.addEventListener('keypress', function (e) {
    if (e.keyCode === 13) {
    console.log('posting message')
    let message = {
        senderName : userName,
        messageText : messageToBePosted.value,
        channelId : channelId,
        userId : userId
    }
    fetch("/channel/createMessage", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(message)
    })
    .then((message) => message.json())
    .then((message) => {console.log(message)})
}})

setInterval(getMessages, 500)

function getMessages() {
    fetch('/channel/${channelId}/getMessages')
        .then((response) => response.json())
        .then((messages) => addMessages (messages)); 
        }
    

function addMessages(messages) {
    var messageCenter = document.getElementById("messageCenter")
    messageCenter.innerHTML = ''
    for(var i = 0; i < messages.length; i++) {
        var div = document.createElement('div')
        div.innerHTML = messages[i].messageSender + ":" + messages[i].messageText;
		messageCenter.appendChild(div);
    }
}
 