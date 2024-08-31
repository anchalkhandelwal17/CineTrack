import React from "react";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";

const Footer = () => {
  return (
    <Navbar bg="dark" variant="dark" className="mt-auto">
      <Container fluid className="d-flex justify-content-between">
        <Nav>
          <Nav.Link href="/help" className="text-light">Help</Nav.Link>
          <Nav.Link href="/licensing" className="text-light">Contact Us</Nav.Link>
          <Nav.Link href="/jobs" className="text-light">Customer Support</Nav.Link>
          <Nav.Link href="/conditions" className="text-light">Terms & Conditions</Nav.Link>
          <Nav.Link href="/privacy" className="text-light">Privacy Policy</Nav.Link>
        </Nav>
        <span className="text-light">
          © Copyright 2024. All Rights Reserved.
        </span>
      </Container>
    </Navbar>
  );
}

export default Footer;
