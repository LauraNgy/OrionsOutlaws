import React from 'react';
import Navbar from 'react-bootstrap/lib/Navbar'
import Nav from 'react-bootstrap/lib/Nav'
import NavDropdown from 'react-bootstrap/lib/NavDropdown'
import Form from 'react-bootstrap/lib/Form'
import FormControl from 'react-bootstrap/lib/FormControl'
import Button from 'react-bootstrap/lib/Button'

const NavBar = (props) => {

  function handleSubmit(event) {
    event.preventDefault();
    const searchString = event.target.searchSubmit.value;
    console.log("from navbar:",props);
    props.handleSearchSubmit(searchString);
  }

  return(
    <Navbar bg="dark" variant="dark" expand="lg">
      <Navbar.Brand href="/"><img src="/images/white-logo.png" alt="company logo" height="35em" width="auto"></img></Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto" defaultActiveKey={window.location.pathname}>
          <Nav.Link href="/customers">Customers</Nav.Link>
          <Nav.Link href="/hunters">Hunters</Nav.Link>
          <Nav.Link href="/bounties">Bounties</Nav.Link>
          <Nav.Link href="/assignments">Assignments</Nav.Link>
          <NavDropdown title="New" id="basic-nav-dropdown">
            <NavDropdown.Item href="/customers/new">Customer</NavDropdown.Item>
            <NavDropdown.Item href="/hunters/new">Hunter</NavDropdown.Item>
            <NavDropdown.Item href="/bounties/new">Bounty</NavDropdown.Item>
            <NavDropdown.Item href="/assignments/new">Assignment</NavDropdown.Item>
          </NavDropdown>
        </Nav>
        <Form onSubmit={handleSubmit} inline>
          <Form.Group controlId="searchSubmit" >
            <FormControl type="text" placeholder="Search" className="mr-sm-2" />
          </Form.Group>
          <Button type="submit" variant="outline-light">Search</Button>
        </Form>
      </Navbar.Collapse>
    </Navbar>
  )
}

export default NavBar;
