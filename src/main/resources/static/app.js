const stompClient = new StompJs.Client({
  brokerURL: "ws://localhost:8080/bexws",
});

stompClient.onConnect = (frame) => {
  setConnected(true);
  console.log("Connected: " + frame);
  stompClient.subscribe("/topic/leaderboard", (leaders) => {
    showLeaderboard(JSON.parse(leaders.body).html);
  });
};

stompClient.onWebSocketError = (error) => {
  console.error("Error with websocket", error);
};

stompClient.onStompError = (frame) => {
  console.error("Broker reported error: " + frame.headers["message"]);
  console.error("Additional details: " + frame.body);
};

function setConnected(connected) {
  $("#connect").prop("disabled", connected);
  $("#disconnect").prop("disabled", !connected);
  if (connected) {
    $("#leaderboard-tbl").show();
  } else {
    $("#leaderboard-tbl").hide();
  }
  $("#leaderboard").html("");
}

function connect() {
  stompClient.activate();
}

function disconnect() {
  stompClient.deactivate();
  setConnected(false);
  console.log("Disconnected");
}

function sendName() {
  stompClient.publish({
    destination: "/app/get-leaders",
    body: JSON.stringify({ username: $("#register").val(), token: "00111000" }),
  });
}

function showLeaderboard(message) {
  $("#leaders").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
  $("form").on("submit", (e) => e.preventDefault());
  $("#connect").click(() => connect());
  $("#disconnect").click(() => disconnect());
  $("#send").click(() => sendName());
});
