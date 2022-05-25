import React, {Component} from 'react';
import './Landing.css';
import LandingHeader from "./LandingHeader";
import LandingCard from "./LandingCard";
import LoginRegister from "./LoginRegister";
import Footer from "./Footer";
import LandingCardGroup from "./LandingCardGroup";
import LandingTestimonials from "./LandingTestimonials";
import DashCustomerHeader from "../CustomerDash/DashCustomerHeader";
import DashSideBar from "../CustomerDash/DashSideBar";
import CustomerFunctions from "../CustomerDash/CustomerFunctions/CustomerFunctions";

// export default function Landing() {
//     const[]
// }

class Landing extends Component {
    constructor(props) {
        super(props);
        // window.localStorage.setItem("username", null)
        this.state = {
            // isLoggedIn: window.localStorage.getItem("username") === null
            isLoggedIn: true,
            selectedMode: "open"
        };
    }

    render() {
        return (
            <div className="container">
                <div className="row">
                    <LandingHeader/>
                </div>
                <div>
                    <section>
                        <div className="row">
                            <div className="col-md-6 mb-3">
                                <LandingCard/>
                            </div>
                            <div className="col-md-6 mb-3">
                                <LoginRegister setIsLoggedIn={this.props.setIsLoggedIn}/>
                                <LandingTestimonials/>
                            </div>
                        </div>
                    </section>
                </div>
                <div className="row my-5">
                    <LandingCardGroup/>
                </div>
                <div className="row">
                    <Footer/>
                </div>
            </div>
        );
    }
}

export default Landing;