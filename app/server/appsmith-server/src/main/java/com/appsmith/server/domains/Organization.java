package com.appsmith.server.domains;

import com.appsmith.external.models.BaseDomain;
import com.appsmith.server.constants.Url;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Document
@Deprecated
public class Organization extends BaseDomain {

    private String domain;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String website;

    private String email;

    private Set<WorkspacePlugin> plugins;

    private String slug;

    private Boolean isAutoGeneratedOrganization;

    @JsonIgnore
    private List<UserRole> userRoles;

    @JsonIgnore
    private String logoAssetId;

    public String getLogoUrl() {
        return Url.ASSET_URL + "/" + logoAssetId;
    }

}
