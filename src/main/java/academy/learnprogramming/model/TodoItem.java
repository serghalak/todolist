package academy.learnprogramming.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of={"id"})
public class TodoItem {

    private int id;
    private String title;
    private String details;
    private LocalDate deadLine;

    public TodoItem(String title, String details, LocalDate deadLine) {
        this.title = title;
        this.details = details;
        this.deadLine = deadLine;
    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDetails() {
//        return details;
//    }
//
//    public void setDetails(String details) {
//        this.details = details;
//    }
//
//    public LocalDate getDeadLine() {
//        return deadLine;
//    }
//
//    public void setDeadLine(LocalDate deadLine) {
//        this.deadLine = deadLine;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof TodoItem)) return false;
//
//        TodoItem todoItem = (TodoItem) o;
//
//        return id == todoItem.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return id;
//    }
//
//    @Override
//    public String toString() {
//        return "TodoItem{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", details='" + details + '\'' +
//                ", deadLine=" + deadLine +
//                '}';
//    }
}
