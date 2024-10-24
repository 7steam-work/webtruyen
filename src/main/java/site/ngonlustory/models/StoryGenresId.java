package site.ngonlustory.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoryGenresId implements Serializable {
    private Integer story;
    private Integer genre;
}