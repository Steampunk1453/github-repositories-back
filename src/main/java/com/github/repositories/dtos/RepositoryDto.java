package com.github.repositories.dtos;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class RepositoryDto  {
    @SerializedName("total_count")
    private long total;
    @SerializedName("items")
    private List<ItemsDto> items;
}
