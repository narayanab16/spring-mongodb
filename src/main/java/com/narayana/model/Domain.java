package com.narayana.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "domain")
@TypeAlias("domain")
public class Domain {
    @Id
    private String id;
    private String domainName;
    private String hostingProvider;

    public Domain(String id, String domainName, String hostingProvider) {
        this.id = id;
        this.domainName = domainName;
        this.hostingProvider = hostingProvider;
    }
    public String getId() {
        return this.id;
    }
    public String getDomainName() {
        return this.domainName;
    }

    public String getHostingProvider() {
        return this.hostingProvider;
    }

    @Override
    public String toString() {
        return "Domain{" +
                "id='" + getId() + '\'' +
                ", domainName='" + domainName + '\'' +
                ", hostingProvider='" + hostingProvider + '\'' +
                '}';
    }
}
