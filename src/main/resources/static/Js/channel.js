var submitBttn = document.querySelector("#submitButton")
var messageToBePosted = document.querySelector("#messageCreation")
var userId = user.userId;
var channelId = window.location.href.substring(window.location.href.lastIndexOf('/') + 1)
console.log(channelId)

submitBttn.addEventListener('click', () => {
    console.log('posting message')
    let message = {
        messageSender : userId,
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
})

function getMessages() {
    fetch('/channel/{channekId}/getMessages', {
        method: "POST",
        headers: {"Content-Type": "application/json"}
        .then((response) => response.json())
        .then((messages) => function (messages) {

        })
    })
}

function addMesages(messages) {
    var messageCenter = documnet.querySelector("#messageCenter")
}
 