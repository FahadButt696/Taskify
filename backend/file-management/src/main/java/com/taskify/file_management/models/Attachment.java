package com.taskify.file_management.models;

import jakarta.persistence.*;

@Entity
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Attachment_seq")
    @SequenceGenerator(name = "Attachment_seq", sequenceName = "Attachment_Sequence", allocationSize = 1)
    @Column(name = "attachment_id")
    private Long id;


    private String fileName;
    private String filePath;

    private String fileType;

    private long ticketId;
}
