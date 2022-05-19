package com.bio.hawaii_bio.entity;

import com.bio.hawaii_bio.dto.ReservationRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp
    private LocalDateTime reservationDate;

//    @ManyToOne
//    @JoinColumn(name="ticketid", referencedColumnName = "id")
//    private Ticket ticket;

    @JsonIgnore
    @OneToMany(
            mappedBy = "reservation",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Ticket> tickets = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "username")
    private User user;

    public Reservation(ReservationRequest body){
        this.id = body.getId();
        this.reservationDate = body.getReservationDate();

    }

}
