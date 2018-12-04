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
 * DPO lié à l'entité commentaire.
 * 
 * @author t.roche
 *
 */
@Entity
@Table(name = "commentaire")
@Data
public class CommentaireDpo implements Serializable {

    /**
     * Serial.
     */
    private static final long serialVersionUID = 1L;

    /** Id du commentaire. */
    @Id
    @Column(name = "id_commentaire")
    private Integer id;

    /** Id du message. */
    @OneToMany
    @JoinColumn(name = "id_message")
    private MessageDpo messageId;

    /** Auteur du commentaire. */
    @Column(name = "auteur")
    private String auteur;

    /** Message. */
    @Column(name = "message")
    private String message;

    /** Date de création du commentaire. */
    @Column(name = "date")
    private Date date;

}
