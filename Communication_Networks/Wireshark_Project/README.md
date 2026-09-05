# 🌐 Network Traffic Analysis with Wireshark

## 📌 Overview

This repository contains the bonus project for the **Communication Networks** course at the Athens University of Economics and Business (AUEB). The primary objective is to gain hands-on experience with network packet capturing, protocol analysis, and troubleshooting using **Wireshark**.

The core of this project revolves around analyzing local network traffic, understanding the behavior of core network protocols (ICMP, DNS, TCP, UDP), and inspecting encrypted web traffic.

## 📄 Full Assignment Details

For the complete task descriptions, constraints, and questions, please refer to the attached official document: 👉 [Wireshark_Project.pdf](wireshark_bonus_project_2025-2026.pdf) *(Note: The document is in Greek)*.

## 🚀 Key Features & Analysis

**Part A: ICMP & Traceroute Analysis**
* **Functionality:** Executed network route tracing (`tracert`) to a remote host (www.acm.org) and captured the corresponding ICMP packets.
* **Protocol Inspection:** Analyzed **ICMP Echo Requests** and **Time Exceeded** messages. Evaluated physical (MAC) and logical (IP) addressing, as well as Time-to-Live (TTL) packet attributes to understand how routers drop expired packets.
* **Network Hierarchy:** Mapped the captured packets to the TCP/IP model, differentiating between Ethernet frames, IPv4/IPv6 datagrams, and UDP/TCP segments.

**Part B: DNS & HTTPS (TLS) Inspection**
* **DNS Resolution:** Flushed the local DNS cache and analyzed the standard queries and responses required to resolve a domain name (`grnet.gr`). Matched queries to responses via Transaction IDs and inspected Authoritative Server flags.
* **Endpoint Analysis:** Differentiated between Ethernet endpoints (local devices like PCs and Routers) and IP endpoints (remote servers), demonstrating a clear understanding of Default Gateway routing.
* **Encrypted Web Traffic:** Monitored the HTTP GET requests towards the resolved IP. Demonstrated how modern web traffic is secured over port 443 by identifying the encrypted payloads operating under the **TLS 1.3** protocol.

## 📂 Repository Structure

* 📄 `wireshark_bonus_project_2025-2026.pdf`: The official academic assignment description and questions.
* 📄 `3160130.pdf`: A detailed technical report containing Wireshark execution screenshots, packet breakdowns, and analytical answers to the assignment's network questions.