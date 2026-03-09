package com.chamnan.inventory_system.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "menu_name", nullable = false, length = 100)
    private String menuName;

    @ColumnDefault("0.000000")
    @Column(name = "order_by", precision = 20, scale = 6)
    private BigDecimal orderBy;

    @Column(name = "url")
    private String url;

    @Column(name = "icon")
    private String icon;

    @Column(name = "parent_id")
    private Long parentId;

    @ColumnDefault("'1'")
    @Column(name = "is_active", nullable = false, length = 1)
    private String isActive;

    @ColumnDefault("0")
    @Column(name = "is_deleted", nullable = false)
    private Byte isDeleted;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @Column(name = "deleted_by", length = 100)
    private String deletedBy;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @ColumnDefault("current_timestamp()")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @ColumnDefault("current_timestamp()")
    @Column(name = "updated_at")
    private Instant updatedAt;


}