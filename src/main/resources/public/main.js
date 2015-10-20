$(function() {

  function loadMessages(){
    var messageList = $('#messages');
    messageList.html('');
    $.get('/messages', function(data){
      $.each(data, function(i, message){
        var messageTime = new Date();
        messageTime.setTime(message.time);
        messageTimeString = messageTime.toLocaleTimeString();
        var content = message.name + ' wrote at '+messageTimeString + ': '+message.text;
        messageList.append($('<li>').text(content));
      });
    });
  }

  loadMessages();

  $('form').submit(function(e){
    e.preventDefault();
    var url = '/message';
    var data = $(this).serialize();
    $.post(url, data).then(function(data, status, xhr) {
      loadMessages();
    });
  });
});