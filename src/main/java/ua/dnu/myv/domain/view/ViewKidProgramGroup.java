package ua.dnu.myv.domain.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

/**
 * Mapping for DB view
 */
@Getter
@Setter
@Entity
@Immutable
@Table(name = "view_kid_program_groups")
public class ViewKidProgramGroup {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "kid_id", nullable = false)
    private Integer kidId;

    @Column(name = "kid_name", nullable = false)
    private String kidName;

    @Column(name = "program_id", nullable = false)
    private Integer programId;

    @Column(name = "program_name")
    private String programName;

    @Column(name = "program_to")
    private String programTo;

    @Column(name = "group_id", nullable = false)
    private Integer groupId;

    @Column(name = "group_name")
    private String groupName;

}