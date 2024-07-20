'use strict';

class History extends React.Component {

    handleAlert = () => {
        alert("Something bad happened :(");
    };

    render() {
        if (!(Array.isArray(this.props.ticketList) && this.props.ticketList.length > 0)) {
            return (
                <p style={{ color: "white", border: "solid black", backgroundColor: "#085394", fontSize: "30px" }}>No Events :(</p>
            );
        }
        else {
            return (
                <div >
                    <p style={{ color: "white", border: "solid black", backgroundColor: "#085394", fontSize: "30px" }}>Past Events: </p>
                    <ul>
                        {this.props.eventList.map((element) => (
                            <li style={{ border: '5px solid' }}>
                                {element}
                                <button onClick={this.handleAlert()}>View Report</button>
                            </li>
                        ))}
                    </ul>
                </div>
            );
        }
    }
}