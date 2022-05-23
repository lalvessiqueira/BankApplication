import React from 'react';
import {MDBContainer, MDBFooter, MDBIcon} from 'mdb-react-ui-kit';

export default function Footer() {
    return (
        <MDBFooter className='text-center rounded-3' style={{color: 'white', background: 'black'}}>
            <MDBContainer className='pt-4'>
                <section className='mb-4'>
                    <a
                        className='btn btn-link btn-floating btn-lg text-dark m-1'
                        href='#!'
                        role='button'
                        data-mdb-ripple-color='dark'
                    >
                        <MDBIcon fab className='fab fa-facebook-f' />
                    </a>

                    <a
                        className='btn btn-link btn-floating btn-lg text-dark m-1'
                        href='#!'
                        role='button'
                        data-mdb-ripple-color='dark'
                    >
                        <MDBIcon fab className='fa-twitter' />
                    </a>

                    <a
                        className='btn btn-link btn-floating btn-lg text-dark m-1'
                        href='#!'
                        role='button'
                        data-mdb-ripple-color='dark'
                    >
                        <MDBIcon fab className='fa-google' />
                    </a>

                    <a
                        className='btn btn-link btn-floating btn-lg text-dark m-1'
                        href='#!'
                        role='button'
                        data-mdb-ripple-color='dark'
                    >
                        <MDBIcon fab className='fa-instagram' />
                    </a>

                    <a
                        className='btn btn-link btn-floating btn-lg text-dark m-1'
                        href='#!'
                        role='button'
                        data-mdb-ripple-color='dark'
                    >
                        <MDBIcon fab className='fa-linkedin' />
                    </a>

                    <a
                        className='btn btn-link btn-floating btn-lg text-dark m-1'
                        href='#!'
                        role='button'
                        data-mdb-ripple-color='dark'
                    >
                        <MDBIcon fab className='fa-github' />
                    </a>
                </section>
            </MDBContainer>

            <div className='text-center p-3' style={{ backgroundColor: 'rgba(0, 0, 0, 0.2)' }}>
                © 2022 Copyright:
                <a style={{color:"white"}} href='https://mdbootstrap.com/'>
                    HenrryWith2Rs.com
                </a>
            </div>
        </MDBFooter>
    );
}