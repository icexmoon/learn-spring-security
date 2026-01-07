package cn.icexmoon.learnspringsecurity.jwt.entity;

import lombok.*;

import java.util.Date;

/**
 * @ClassName RefreshToken
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2026/1/7 10:52
 * @Version 1.0
 */
@Builder
@Getter
@ToString
public class RefreshToken {
    private final String id;
    private final String userName;
    private final Date expiryDate;
    private final Date issuedAt;
}
