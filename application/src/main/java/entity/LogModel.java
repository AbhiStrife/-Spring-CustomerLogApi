package entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LogModel {
    
    @Id
    private String id;
    private String name;
    private String logType;
    @Column(name = "log_date")
    private String logDate;
    @Column(name = "log_time")
    private String logTime;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogType() {
        return logType;
    }
    public void setLogType(String logType) {
        this.logType = logType;
    }
    public String getLogDate() {
        return logDate;
    }
    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }
    public String getLogTime() {
        return logTime;
    }
    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public LogModel(String name, String logType) {
        DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());

        this.name = name;
        this.logType = logType;
        this.logDate = dateFormat.format(date);
        this.logTime = timeFormat.format(date);
        this.id = name+" "+logTime;
    }

    public LogModel(){
        super();
    }
}
