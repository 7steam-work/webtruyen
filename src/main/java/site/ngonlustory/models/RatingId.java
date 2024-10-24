package site.ngonlustory.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingId implements Serializable {
    private Integer user;
    private Integer story;
}