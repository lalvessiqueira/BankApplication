import React, {Component} from 'react';
import {MDBBtn, MDBCheckbox, MDBCol, MDBInput, MDBRow} from "mdb-react-ui-kit";

class UpdatePassword extends Component {
    render() {
        return (
            <div className="container rounded-3" id='bg-glass'>
                <form>
                    <MDBRow className='mb-4'>
                        <MDBCol>
                            <MDBInput className='mt-4' label='Username' disabled/>
                        </MDBCol>
                    </MDBRow>

                    <MDBRow className='mb-4'>
                        <MDBCol>
                            <MDBInput wrapperClass='mb-4' type='text' label='Enter Password' />
                            <MDBInput wrapperClass='mb-2' type='text' label='Confirm Password' />
                        </MDBCol>
                    </MDBRow>

                    <MDBBtn className='mb-4' type='submit'>
                        Update
                    </MDBBtn>

                    <MDBRow className='mb-4'>
                        <MDBCol>
                            <p>Already have a Customer account? <a href='#!'>Login here</a></p>
                        </MDBCol>
                    </MDBRow>
                </form>
            </div>
        );
    }
}

export default UpdatePassword;