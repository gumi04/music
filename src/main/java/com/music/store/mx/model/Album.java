/* 
* This program is free software: you can redistribute it and/or modify  
* it under the terms of the GNU General Public License as published by  
* the Free Software Foundation, version 3.
*
* This program is distributed in the hope that it will be useful, but 
* WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
* General Public License for more details.
*
* Nombre de archivo: Album.java
* Autor: gcontrer
* Fecha de creación: 20 sep. 2021
*/

package com.music.store.mx.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class Album.
 */
@Entity
@Table(name = "Album")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Album {

  /** The album id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idAlbum", nullable = false, length = 11)
  private Long albumId;

  /** The title. */
  @Column(name = "titulo", nullable = false, length = 45)
  private String title;

  /** The launch. */
  @Column(name = "lanzamiento")
  private LocalDateTime launch;

  /** The company. */
  @Column(name = "disquera", nullable = false, length = 45)
  private String company;

  /** The singer. */
  @Column(name = "cantante", nullable = false, length = 45)
  private String singer;

  /** The gender. */
  @Column(name = "genero", nullable = false, length = 45)
  private String gender;

  /** The image. */
  @Column(name = "cobertura", length = 250)
  private String image;
}
