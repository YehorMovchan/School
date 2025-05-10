package ua.dnu.myv.domain.view;

import jakarta.persistence.*;
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
@Table(name = "view_program_groups")
public class ViewProgramGroup {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "group_id", nullable = false)
    private Integer groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "price")
    private Integer price;

    @Lob
    @Column(name = "group_info")
    private String groupInfo;

    @Column(name = "leader")
    private Integer leader;

    @Column(name = "program_id", nullable = false)
    private Integer programId;

    @Column(name = "program_name")
    private String programName;

    @Lob
    @Column(name = "program_info")
    private String programInfo;

}