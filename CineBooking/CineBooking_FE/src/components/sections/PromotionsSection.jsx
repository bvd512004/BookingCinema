import { Button, Card, Col, Container, Row } from 'react-bootstrap'

const promos = [
  {
    title: 'Combo Bắp Nước 50.000đ',
    desc: 'Áp dụng cho chủ thẻ thành viên khi mua combo bắp và nước.',
    thumb:
      'https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=420&q=80',
  },
  {
    title: 'Giảm 20% thẻ ngân hàng',
    desc: 'Ưu đãi dành cho thẻ Napas vào cuối tuần.',
    thumb:
      'https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=420&q=80',
  },
]

function PromotionsSection() {
  return (
    <section className="promotions" id="uu-dai">
      <Container>
        <div className="section-title">
          <h2>Khuyến Mãi & Tin Tức</h2>
          <a href="/">Xem tất cả tin tức</a>
        </div>
        <Row className="promo-grid g-3">
          {promos.map((promo) => (
            <Col md={6} key={promo.title}>
              <Card className="promo-card h-100">
                <Card.Body>
                  <div className="promo-content">
                    <div>
                      <h3>{promo.title}</h3>
                      <p>{promo.desc}</p>
                      <Button type="button" className="promo-btn">
                        Chi tiết
                      </Button>
                    </div>
                    <img src={promo.thumb} alt={promo.title} className="promo-thumb" />
                  </div>
                </Card.Body>
              </Card>
            </Col>
          ))}
        </Row>
      </Container>
    </section>
  )
}

export default PromotionsSection
