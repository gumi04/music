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
* Nombre de archivo: AlbumMapper.java
* Autor: gcontrer
* Fecha de creación: 20 sep. 2021
*/

package com.music.store.mx.application.mapper;

import com.music.store.mx.application.dto.AlbumDto;
import com.music.store.mx.model.Album;

/**
 * The Class AlbumMapper.
 */
public class AlbumMapper {

  /**
   * Instantiates a new album mapper.
   */
  private AlbumMapper() {
    super();
  }


  /**
   * To model.
   *
   * @param albumDto the album dto
   * @return the album
   */
  public static Album toModel(AlbumDto albumDto) {
    return Album.builder().albumId(albumDto.getAlbumId()).title(albumDto.getTitle())
        .launch(albumDto.getLaunch()).company(albumDto.getCompany()).singer(albumDto.getSinger())
        .gender(albumDto.getGender()).image(albumDto.getImage()).build();
  }


  /**
   * To dto.
   *
   * @param album the album
   * @return the album dto
   */
  public static AlbumDto toDto(Album album) {
    return AlbumDto.builder().albumId(album.getAlbumId()).title(album.getTitle())
        .launch(album.getLaunch()).company(album.getCompany()).singer(album.getSinger())
        .gender(album.getGender()).image(album.getImage()).build();
  }

}
