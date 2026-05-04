package org.portfolio.protfolioweb.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.portfolio.protfolioweb.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PortfolioController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/albums")
    public List<Map<String, Object>> getAlbums() {
        return Arrays.asList(
            createAlbum("Dreams Collection", "2017", "A collection of dreamy melodies", 6),
            createAlbum("Classical Fusion", "2019", "Blending classical with modern elements", 5),
            createAlbum("Live at Berklee", "2022", "Recorded live at Berklee College", 5)
        );
    }

    private Map<String, Object> createAlbum(String title, String year, String description, int tracks) {
        Map<String, Object> album = new HashMap<>();
        album.put("title", title);
        album.put("year", year);
        album.put("description", description);
        album.put("tracks", tracks);
        return album;
    }

    @GetMapping("/events")
    public List<Map<String, Object>> getEvents() {
        return Arrays.asList(
            createEvent("Summer Concert Series", "June 15, 2024", "Boston, MA"),
            createEvent("New York City Showcase", "June 28, 2024", "New York, NY"),
            createEvent("Lollapalooza", "July 12, 2024", "Chicago, IL")
        );
    }

    private Map<String, Object> createEvent(String title, String date, String location) {
        Map<String, Object> event = new HashMap<>();
        event.put("title", title);
        event.put("date", date);
        event.put("location", location);
        return event;
    }

    @PostMapping("/contact")
    public Map<String, Object> contact(@RequestBody Map<String, String> payload) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Message received! I'll get back to you soon.");
        return response;
    }

    @PostMapping("/send-email")
    public ResponseEntity<Map<String, Object>> sendEmail(@RequestBody Map<String, String> payload) {
        Map<String, Object> response = new HashMap<>();
        try {
            emailService.sendContactEmail(payload);
            response.put("success", true);
            response.put("message", "Message sent successfully!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("success", false);
            response.put("message", "Failed to send message: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/about")
    public Map<String, Object> getAbout() {
        Map<String, Object> about = new HashMap<>();
        about.put("name", "Harmony");
        about.put("title", "Professional Musician & Composer");
        about.put("bio", "With over a decade of experience, I create music that touches the soul.");
        about.put("experience", "10+ years");
        about.put("projects", 50);
        about.put("listeners", "100K+");
        return about;
    }
}
