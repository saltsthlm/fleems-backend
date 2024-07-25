package com.lans.fleems.task.service;

import com.lans.fleems.leg.model.Leg;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.task.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    @Value("${travel-time.application-id}")
    private static String applicationId;
    @Value("${travel-time.apikey}")
    private static String apiKey;


    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public Task getTaskById(UUID taskId) {
        return taskRepository.getTaskById(taskId);
    }

    public Task createTask(Task Task) {
        return taskRepository.createTask(Task);
    }

    public void deleteTaskById(UUID taskId) {
        taskRepository.deleteById(taskId);
    }

    public Task updateTask(Task task) {
        return taskRepository.updateTask(task);
    }

    public Task addLeg(Leg leg, UUID taskId) {
       Task task = taskRepository.getTaskById(taskId);
        leg.setTask(task);
        task.getLegs().add(leg);
       return taskRepository.updateTask(task);
    }





}
/*
curl -X POST https://api.traveltimeapp.com/v4/time-filter \
-H 'Content-Type: application/json' \
-H 'Accept: application/json' \
-H 'X-Application-Id: f1a5a5c7' \
-H 'X-Api-Key: 3c44d6a8a3d2516ce7d1b02bbca41ef1' \
-d '{
  "locations": [
    {
      "id": "London center",
      "coords": {
        "lat": 51.508930,
        "lng": -0.131387
      }
    },
    {
      "id": "Hyde Park",
      "coords": {
        "lat": 51.508824,
        "lng": -0.167093
      }
    },
    {
      "id": "ZSL London Zoo",
      "coords": {
        "lat": 51.536067,
        "lng": -0.153596
      }
    }
  ],
  "departure_searches": [
    {
      "id": "departure search example",
      "departure_location_id": "London center",
      "arrival_location_ids": [
        "Hyde Park",
        "ZSL London Zoo"
      ],
      "departure_time": "2024-07-23T09:00:00Z",
      "travel_time": 1900,
      "properties": [
        "travel_time"
      ],
      "transportation": {
        "type": "bus",
        "max_changes": {
          "enabled": true,
          "limit": 3
        }
      },
      "range": {
        "enabled": true,
        "max_results": 3,
        "width": 600
      }
    }
  ],
  "arrival_searches": [
    {
      "id": "arrival search example",
      "departure_location_ids": [
        "Hyde Park",
        "ZSL London Zoo"
      ],
      "arrival_location_id": "London center",
      "arrival_time": "2024-07-23T10:00:00Z",
      "travel_time": 1900,
      "properties": [
        "travel_time",
        "distance",
        "distance_breakdown",
        "fares"
      ],
      "transportation": {
        "type": "public_transport"
      }
    }
  ]
}'
 */