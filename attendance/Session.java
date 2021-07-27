package attendance;

import java.util.Date;

public class Session {
    private Date date;
    private String room;
    private String topic;

    public Session(){}

    public Session(Date date, String room, String topic){
        this.date = date;
        this.room = room;
        this.topic = topic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}
