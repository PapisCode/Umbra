INSERT INTO brands (name) VALUES ('Umbra Essentials')
ON CONFLICT (name) DO NOTHING;
INSERT INTO brands (name) VALUES ('OVO Inspired')
ON CONFLICT (name) DO NOTHING;
INSERT INTO brands (name) VALUES ('Street Core')
ON CONFLICT (name) DO NOTHING;
INSERT INTO brands (name) VALUES ('Midnight Label')
ON CONFLICT (name) DO NOTHING;

INSERT INTO categories (name) VALUES ('Hoodie')
ON CONFLICT (name) DO NOTHING;
INSERT INTO categories (name) VALUES ('T-Shirt')
ON CONFLICT (name) DO NOTHING;
INSERT INTO categories (name) VALUES ('Jacket')
ON CONFLICT (name) DO NOTHING;
INSERT INTO categories (name) VALUES ('Cap')
ON CONFLICT (name) DO NOTHING;
INSERT INTO categories (name) VALUES ('Accessory')
ON CONFLICT (name) DO NOTHING;

INSERT INTO items (name, sku, price, description, created_at, brand_id, category_id) VALUES
('Shadow Hoodie', 'UMB-HOOD-001', 119.99, 'Premium heavyweight hoodie with minimalist branding.', CURRENT_TIMESTAMP, 1, 1),
('Noir Tee', 'UMB-TEE-002', 49.99, 'Classic black t-shirt with soft cotton finish.', CURRENT_TIMESTAMP, 2, 2),
('Urban Windbreaker', 'UMB-JACK-003', 159.99, 'Lightweight jacket for everyday streetwear.', CURRENT_TIMESTAMP, 3, 3),
('Moon Cap', 'UMB-CAP-004', 39.99, 'Curved cap with clean embroidered logo.', CURRENT_TIMESTAMP, 4, 4),
('Signature Hoodie', 'UMB-HOOD-005', 129.99, 'Luxury fleece hoodie with relaxed fit.', CURRENT_TIMESTAMP, 2, 1),
('Core Tee', 'UMB-TEE-006', 44.99, 'Everyday tee with premium stitching.', CURRENT_TIMESTAMP, 1, 2),
('Tech Shell Jacket', 'UMB-JACK-007', 189.99, 'Functional shell jacket with weather resistance.', CURRENT_TIMESTAMP, 3, 3),
('Umbra Tote', 'UMB-ACC-008', 34.99, 'Durable tote bag for essentials.', CURRENT_TIMESTAMP, 4, 5),
('Graphite Hoodie', 'UMB-HOOD-009', 114.99, 'Clean-cut hoodie with brushed interior.', CURRENT_TIMESTAMP, 1, 1),
('Nightfall Cap', 'UMB-CAP-010', 42.99, 'Street-style cap in matte black.', CURRENT_TIMESTAMP, 3, 4)
ON CONFLICT (sku) DO NOTHING;