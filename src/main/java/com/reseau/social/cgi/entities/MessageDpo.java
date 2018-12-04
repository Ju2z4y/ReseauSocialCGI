package com.reseau.social.cgi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * DPO lié à l'entité message.
 * 
 * @author t.roche
 *
 */
@Entity
@Table(name = "message")
@Data
public class MessageDpo implements Serializable {

    /**
     * Serial.
     */
    private static final long serialVersionUID = 1L;

    /** Id du message. */
    @Id
    @Column(name = "id_message")
    private Integer id;

    /** Id du topic. */
    @OneToMany
    @JoinColumn(name = "id_topic")
    private TopicDpo topic;

    /** Auteur du message. */
    @Column(name = "auteur")
    private String auteur;

    /** Message. */
    @Column(name = "message")
    private String message;

    /** Date de création du message. */
    @Column(name = "date")
    private Date date;

}
