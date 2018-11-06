import React from 'react'
import Container from 'react-bootstrap/lib/Container'
import Row from 'react-bootstrap/lib/Row'
import Image from'react-bootstrap/lib/Image'
import Col from 'react-bootstrap/lib/Col'
import ListGroup from 'react-bootstrap/lib/ListGroup'
import Header from '../header';

const BountyDetail = (props) => {
  const path = props.data.imagePath
  const image = path ? path : "https://dummyimage.com/400x400/000/fff.png&text=No Image"
  return(
    <div>
      <Header title={`Bounty: ${props.data.targetName}`} />
      <Container>
        <Row>
          <Col md={4}>
            <Image src={image} fluid/>
          </Col>
          <Col md={7}>
            <ListGroup variant="flush">
              <ListGroup.Item>Reward Value: £{props.data.reward}</ListGroup.Item>
              <ListGroup.Item>Completed: {props.data.completed.toString()}</ListGroup.Item>
            </ListGroup>
          </Col>
        </Row>
      </Container>
    </div>
  )
}

export default BountyDetail;
