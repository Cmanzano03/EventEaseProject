'use strict';

class App extends React.Component {
    constructor() {
        super();
        this.state = {
            page: "home",
            eventList: 0
        }
        this.onNavigate = this.onNavigate.bind(this);
    }

    onNavigate(e) {
        this.setState({
            page: e.target.name
        });
    };

    llamadaAjax() {

        fetch('Admin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            //body: JSON.stringify(requestData)
            body: ""
        })
            .then(response => response.json())
            .then(data => {
                this.setState({ eventList: data });
                // console.log('Search results:', data);
            })
            .catch(error => {
                console.error('There was an error making the request:', error);
            });
    }

    render() {
        let pageContent;
        this.llamadaAjax();
        switch (this.state.page) {
            case "home":
                pageContent = <HomePage color="#6aa84f" onNavigate={this.onNavigate} />;
                break;
            case "history":
                pageContent = <History eventList={this.props.eventList} onNavigate={this.onNavigate}/>;
                break;
            case "view":
                pageContent = <ViewEvents eventList={this.props.eventList} onNavigate={this.onNavigate} />;
                break;
            case "create":
                pageContent = <Create onNavigate={this.onNavigate}/>;
                break;
            default:
                pageContent = <HomePage color="#6aa84f" onNavigate={this.onNavigate} />;
        }

        return (
            <div>
                {pageContent}
            </div>
        );
    }
}
