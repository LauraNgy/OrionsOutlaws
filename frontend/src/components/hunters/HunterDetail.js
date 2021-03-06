import React from 'react'
import Container from 'react-bootstrap/lib/Container'
import Row from 'react-bootstrap/lib/Row'
import Image from'react-bootstrap/lib/Image'
import Col from 'react-bootstrap/lib/Col'
import ListGroup from 'react-bootstrap/lib/ListGroup'
import Header from '../header';

const HunterDetail = (props) => {
  const path = props.data.imagePath
  const image = path ? path : "https://dummyimage.com/400x400/000/fff.png&text=No Image"
  return(
    <div>
      <Header title={`Hunter: ${props.data.name}`} />
      <Container>
        <Row>
          <Col md={4}>
            <Image src={image} fluid/>
          </Col>
          <Col md={7}>
            <ListGroup variant="flush">
              <ListGroup.Item>Email Address: {props.data.emailAdress}</ListGroup.Item>
              <ListGroup.Item>Wallet: £{props.data.wallet}</ListGroup.Item>
              <ListGroup.Item>Current Status: {props.data.hunterStatus.toString().toLowerCase()}</ListGroup.Item>
            </ListGroup>
          </Col>
        </Row>
      </Container>
    </div>
  )
}

export default HunterDetail;
