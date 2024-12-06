package ru.skypro.homework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


//@Table(name = "images")
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Data
//@AllArgsConstructor
//@Entity
//public class ImageAdEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String path;
//    @Column(name = "file_size")
//    private long fileSize;
//    @Column(name = "media_type")
//    private String mediaType;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ad_id")
//    private AdEntity ad;
//
//    public ImageAdEntity() {
//
//    }
//}

@Table(name = "images")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@Entity
public class ImageAdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    private long fileSize;
    private String mediaType;
    @JsonIgnore
    private byte[] data;

    @OneToOne
    @JsonIgnore
    private AdEntity ad;

    public ImageAdEntity() {

    }
}
