import React from 'react';
import { MDBCard, MDBCardImage, MDBCardBody, MDBCardTitle, MDBCardText, MDBCardLink, MDBListGroup, MDBListGroupItem } from 'mdb-react-ui-kit';

export default function DashSideBar() {
    return (
        <MDBCard style={{ width: '18rem', color: 'black' }} id='bg-glass'>
            <MDBCardImage position='top' alt='...' src='https://mdbootstrap.com/img/new/standard/city/062.webp' />
            <MDBCardBody>
                <MDBCardTitle>Card title</MDBCardTitle>
                <MDBCardText>
                    Some quick example text to build on the card title and make up the bulk of the card's content.
                </MDBCardText>
            </MDBCardBody>
            <MDBListGroup flush>
                <MDBListGroupItem style={{background: "none"}}>Create Account</MDBListGroupItem>
                <MDBListGroupItem style={{background: "none"}}>Add Beneficiary</MDBListGroupItem>
                <MDBListGroupItem style={{background: "none"}}>Remove Beneficiary</MDBListGroupItem>
                <MDBListGroupItem style={{background: "none"}}>Transfer Funds</MDBListGroupItem>
                <MDBListGroupItem style={{background: "none"}}>View Statement</MDBListGroupItem>
            </MDBListGroup>
            <MDBCardBody>
                <MDBCardLink href='#'>Card link</MDBCardLink>
                <MDBCardLink href='#'>Card link</MDBCardLink>
            </MDBCardBody>
        </MDBCard>
    );
}