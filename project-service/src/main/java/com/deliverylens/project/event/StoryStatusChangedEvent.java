package com.deliverylens.project.event;

public class StoryStatusChangedEvent {
    private Long storyId;

    private Long sprintId;
    private String oldStatus;
    private String newStatus;

    public StoryStatusChangedEvent() {


    }

    public Long getStoryId() {
        return storyId;
    }

    public void setStoryId(Long storyId) {
        this.storyId = storyId;
    }

    public Long getSprintId() {
        return sprintId;
    }

    public void setSprintId(Long sprintId) {
        this.sprintId = sprintId;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public StoryStatusChangedEvent(
            Long storyId,
            Long sprintId,
            String oldStatus,
            String newStatus) {
        this.storyId = storyId;
        this.sprintId = sprintId;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;

    }
}