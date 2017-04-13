# Overview

This is a DBMS for SJTU SEIEE Social Practice Department, also my personal course project for *Database Concept*. 

The whole project is designed to solve the problem that massive documents need to collect during social practice period. As one of the leader of Social Practice Department who experienced inconvenience of the traditional FTP method, a database system will be a great replacement for FTP.

The system will include three part in design: server part, website part and android part, also ought to be finished before this semester ends.

# Server Part

## Framework

- Hibernate 5.2.9
- Spring Boot 1.4.5
- Thymeleaf 3.0.5

## Hibernate

### Relation List

**Student - Leader**

| SrcEntity      | Relation                   | TargetEntity |
| -------------- | -------------------------- | ------------ |
| Member         | Bi-directional Many-To-One | Leader       |
| SpecialStudent | Bi-directional Many-To-One | Leader       |

**Leader - Team**

| SrcEntity | Relation                  | TargetEntity |
| --------- | ------------------------- | ------------ |
| Leader    | Bi-directional One-To-One | Team         |

**Team - Teacher**

| SrcEntity | Relation                   | TargetEntity |
| --------- | -------------------------- | ------------ |
| Team      | Bi-directional Many-To-One | Instructor   |
| Team      | Bi-directional Many-To-One | Expert       |

