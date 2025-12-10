package org.example.model;

public class ProgressResponse {
    private long userId;
    private long courseId;
    private int completedLessons;
    private int totalLessons;
    private double progressPercentage;

    public ProgressResponse(long userId, long courseId, int completedLessons, int totalLessons) {
        this.userId = userId;
        this.courseId = courseId;
        this.completedLessons = completedLessons;
        this.totalLessons = totalLessons;
        this.progressPercentage = totalLessons == 0 ? 0 : (completedLessons * 100.0) / totalLessons;
    }

    public long getUserId() { return userId; }
    public long getCourseId() { return courseId; }
    public int getCompletedLessons() { return completedLessons; }
    public int getTotalLessons() { return totalLessons; }
    public double getProgressPercentage() { return progressPercentage; }
}
