package org.example.service;

import org.example.model.ProgressResponse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseService {

    // Simulated DB
    private final Set<String> enrollments = new HashSet<>();
    private final Map<String, Set<Long>> lessonCompletions = new HashMap<>();

    // Mock lessons per course
    private final Map<Long, Integer> courseLessons = Map.of(
            101L, 10,
            102L, 8
    );

    public String enrollUser(long userId, long courseId) {
        String key = userId + "_" + courseId;

        if (enrollments.contains(key)) {
            return "User already enrolled";
        }

        enrollments.add(key);
        return "Enrollment successful";
    }

    public String completeLesson(long userId, long courseId, long lessonId) {
        String key = userId + "_" + courseId;

        if (!enrollments.contains(key)) {
            return "User not enrolled in this course";
        }

        lessonCompletions.putIfAbsent(key, new HashSet<>());

        // Idempotent behavior: Set prevents duplicate completion
        lessonCompletions.get(key).add(lessonId);

        return "Lesson marked as completed";
    }

    public ProgressResponse getProgress(long userId, long courseId) {
        String key = userId + "_" + courseId;

        int totalLessons = courseLessons.getOrDefault(courseId, 0);
        int completed = lessonCompletions.getOrDefault(key, new HashSet<>()).size();

        return new ProgressResponse(userId, courseId, completed, totalLessons);
    }
}
