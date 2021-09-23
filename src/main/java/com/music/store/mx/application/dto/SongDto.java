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
* Nombre de archivo: SongDto.java
* Autor: gcontrer
* Fecha de creación: 20 sep. 2021
*/

package com.music.store.mx.application.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class SongDto.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {

  /** The song id. */
  private Long songId;
  
  /** The title. */
  private String title;
  
  /** The album id. */
  private Long albumId;
  
  /** The author. */
  private String author;
  
  /** The length. */
  private Float length;


}
