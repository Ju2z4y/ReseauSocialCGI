package com.reseau.social.cgi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

/**
 * DPO lié à l'entité topic.
 * 
 * @author t.roche
 *
 */
@Entity
@Table(name = "autorisation_echange")
@Data
public class TopicDpo implements Serializable {

    /**
     * Serial.
     */
    private static final long serialVersionUID = 1L;

    /** Id du topic. */
    @Id
    @Column(name = "id_topic")
    private Integer id;

    /** Auteur du topic. */
    @Column(name = "auteur")
    private String auteur;

    /** Message du topic. */
    @Column(name = "message")
    private String message;

    /** Date de création du topic. */
    @Column(name = "date")
    private Date date;

    /** Titre du topic. */
    @Column(name = "titre")
    private String titre;

}
