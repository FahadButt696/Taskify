package com.taskify.notification_management;

import com.sda.project.backend.enums.NotificationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Notification {
    @Id
    @Column(name = "Notification_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Notification_Seq")
    @SequenceGenerator(name = "Notification_Seq", sequenceName = "Notification_sequence", allocationSize = 1)
    private Long id;

    @NotEmpty(message = "content should not be empty!!")
    private String content;


    private boolean isRead;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    @ManyToOne
    private User receiver;
}
