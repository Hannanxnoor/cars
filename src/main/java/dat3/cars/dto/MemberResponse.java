package dat3.cars.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.cars.entity.Member;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor //A must for @Builder
@Builder  //I will demo it's purpose in the class
//It's really IMPORTANT that you understand the purpose of this annotation
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberResponse {
    String username; //Remember this is the primary key
    //Observe password is obviously not included
    String email;
    String firstName;
    String lastName;
    String street;
    String city;
    String zip;
    //@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;
    Integer ranking;
    Boolean approved;

    List<ReservationResponse> reservations;

    //Convert Member Entity to Member DTO
    public MemberResponse(Member m, boolean includeAll) {
        this.username = m.getUsername();
        this.email = m.getEmail();
        this.street = m.getStreet();
        this.firstName =m.getFirst_name();
        this.lastName = m.getLast_name();
        this.city = m.getCity();
        this.zip = m.getZip();
        if(includeAll){
            this.created = m.getCreated();
            this.edited = m.getLastEdited();
            this.approved = m.isApproved();
            this.ranking = m.getRanking();
            this.reservations = m.getReservations()
                    .stream()
                    .map(reservation -> new ReservationResponse(reservation))
                    .toList();
        }
    }









}

