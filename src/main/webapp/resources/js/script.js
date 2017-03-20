var stompClient = null;

function setConnected(connected) {

    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('response').innerHTML = '';
}

function connect() {

    var socket = new SockJS('/webchat/chat');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function(frame) {

        setConnected(true);
        console.log('Connected: ' + frame);

        serviceMessage(' joined the chat');

        stompClient.subscribe('/topic/messages', function(messageOutput) {
            showMessageOutput(JSON.parse(messageOutput.body));
        });
    });
}

function disconnect() {

    if(stompClient != null) {
        serviceMessage(' is leave to the chat');

        stompClient.disconnect();
    }

    setConnected(false);
    console.log("Disconnected");


}

function sendMessage() {
    var from = document.getElementById('from').value;
    var text = document.getElementById('text').value;
    stompClient.send("/app/chat", {}, JSON.stringify({'from':from, 'text':text}));
}

function serviceMessage(hint) {
    var from = document.getElementById('from').value;
    from = from.length > 0 ? from : 'anonimus';
    stompClient.send("/app/chat", {}, JSON.stringify({'from':"service msg", 'text':from + hint}));
}

function showMessageOutput(messageOutput) {
    var response = document.getElementById('response');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(messageOutput.from + ": " + messageOutput.text + " (" + messageOutput.time + ")"));
    response.appendChild(p);
}